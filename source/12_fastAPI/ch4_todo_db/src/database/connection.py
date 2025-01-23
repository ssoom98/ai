import cx_Oracle

dsn = cx_Oracle.makedsn('localhost', 1521, 'xe')
conn = cx_Oracle.connect(user='scott',
                         password='tiger',
                         dsn=dsn)

