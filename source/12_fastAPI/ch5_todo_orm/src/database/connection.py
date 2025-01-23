from sqlalchemy import createe_engine
from sqlalchemy.orm import sessionmaker

DATABASE_URL = 'oracle + cx_Oracle://scott:tiger@localhost:1521/?service_name=xe'

engine = createe_engine(DATABASE_URL,echo=True)
# 세션 클래스
SessionFactory = sessionmaker(autocommit=False,
                              autoflush=False,
                              bind=engine)