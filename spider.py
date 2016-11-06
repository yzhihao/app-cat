#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# Created on 2016-10-26 13:52:57
# Project: test_education

from pyspider.libs.base_handler import *
import re
import time
DIR_PATH = 'E:/'

#主类
class Handler(BaseHandler):
    def __init__(self):
        self.db=dbutil()
        self.deal = Deal()
    
    crawl_config = {
    }

    @every(minutes=24 * 60)
    def on_start(self):
        self.crawl('http://www.apple.com/cn/itunes/charts/paid-apps/',callback=self.index_page)

        
        

    @config(age=10 * 24 * 60 * 60)
    def index_page(self, response):
        a=time.localtime();
        for each in response.doc('a[href^="http"]').items():
            if re.match("https://itunes.apple.com/cn/app/.+", each.attr.href, re.U):
                self.crawl(each.attr.href, callback=self.domain_page,save={'app_url': each.attr.href},validate_cert=False)  
        
                

    
    def detail_page(self,app_id,name,imgpath,app_url,developer,price,tag):
        conn,cursor=self.db.getcon()
        cursor.execute('insert into app (id,name,img_path,app_url,developer,tag)'
                               ' values (%s,%s,%s,%s,%s,%s);',[app_id,name,imgpath,app_url,developer,tag])
        self.db.closecon(conn,cursor)
       

    def domain_page(self, response):
        title=response.doc('#title .left h1').text()
        name=title.split(':')[0]
        price=response.doc('.price').text()
        developer=response.doc('#title .left h2 ').text()
        app_url=response.save['app_url']
        app_url=app_url.split('?')[0]
        imgs = response.doc('#left-stack .lockup a .artwork meta').items()
        app_id=app_url.split('id')[1]
       
        '''
         return [{'app_id':app_id,
                 }]
        img_path=''
        for img in imgs:
                img_path = img.attr.content
    
        return [{'title':name,
              'price':price, 
              'app_url':app_url,
              'developer':developer,
              'img_path':img_path,
                 }]
       '''
        dir_path = self.deal.mkDir(app_id)
        dbimgpath=''
        if dir_path:
            imgs = response.doc('#left-stack .lockup a .artwork meta').items()
            for img in imgs:
                url = img.attr.content
                if url:
                    extension = self.deal.getExtension(url)
                    file_name = app_id +  '.' + extension
                    dbimgpath=dir_path+'/'+file_name
                    self.crawl(img.attr.content, callback=self.save_img,
                               save={'dir_path': dir_path,  'file_name':file_name},validate_cert=False)
            self.detail_page(app_id,name,dbimgpath, app_url,developer,price,0)
                

    def save_img(self, response):
        content = response.content
        dir_path = response.save['dir_path']
        file_name = response.save['file_name']
        file_path = dir_path + '/' + file_name
        self.deal.saveImg(content, file_path)
        
        
        
#连接数据库的until类
# -*- coding: utf-8 -*-
import mysql.connector

class dbutil():
    def __init__(self):
        pass

    def getcon(self):
        conn = mysql.connector.connect(user='root', password='123456', database='app_cat', use_unicode=True)
        cursor = conn.cursor()
        return conn,cursor


    def closecon(self,con,cursor):
        con.commit()
        cursor.close()
        con.close()
        
        
#图片保存的until类
import os

class Deal:
    def __init__(self):
        self.path = DIR_PATH
        if not self.path.endswith('/'):
            self.path = self.path + '/'
        if not os.path.exists(self.path):
            os.makedirs(self.path)

    def mkDir(self, path):
        path = path.strip()
        dir_path = self.path + path
        exists = os.path.exists(dir_path)
        if not exists:
            os.makedirs(dir_path)
            return dir_path
        else:
            return dir_path

    def saveImg(self, content, path):
        f = open(path, 'wb')
        f.write(content)
        f.close()

    def saveBrief(self, content, dir_path, name):
        file_name = dir_path + "/" + name + ".txt"
        f = open(file_name, "w+")
        f.write(content.encode('utf-8'))

    def getExtension(self, url):
        extension = url.split('.')[-1]
        return extension
        