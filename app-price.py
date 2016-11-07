#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# Created on 2016-10-26 13:52:57
# Project: test_education

from pyspider.libs.base_handler import *
import re
import time
DIR_PATH = 'C:/appcat-amg/'

#主类
class Handler(BaseHandler):
    def __init__(self):
        self.db=dbutil()
        
    
    crawl_config = {
    }

    @every(minutes=24 * 60)
    def on_start(self):
        conn,cursor=self.db.getcon()
        app_url=set()
        cursor.execute('select app_url from app;')
        app_url = cursor.fetchall()
        self.db.closecon(conn,cursor)
        for app_url_one in app_url:
            appendurl=str(app_url_one[0])
            appif=str(app_url_one[0]).split('/app')[0]
            
            if(appif=='https://itunes.apple.com/cn'):
                self.crawl(appendurl, callback=self.domain_page,save={'app_url': appendurl},validate_cert=False)
            else:
                self.crawl(appendurl, callback=self.index_page,save={'app_url': appendurl},validate_cert=False)
        

    
    def detail_page(self,app_id,price):
        conn,cursor=self.db.getcon()
        a=time.localtime();
        cursor.execute('delete from  app_cur_info where app_id=(%s);',[app_id])
        cursor.execute('insert into app_history_info (app_id,price,time)'
                               ' values (%s,%s,%s);',[app_id,price,a])
        cursor.execute('insert into app_cur_info (app_id,price,time)'
                               ' values (%s,%s,%s);',[app_id,price,a])
        self.db.closecon(conn,cursor)
       
        
    def index_page(self, response):
        price=response.doc('#price').text()
        app_url=response.save['app_url']
        app_url=app_url.split('?')[0]
        app_id=app_url.split('.html')[0]
        app_id=app_id.split('-')[-1]
        self.detail_page(app_id,price)
            
        
        
    def domain_page(self, response):
        price=response.doc('.price').text()
        app_url=response.save['app_url']
        app_url=app_url.split('?')[0]
        app_id=app_url.split('id')[1]
        self.detail_page(app_id,price)
                
        
        
        
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
        