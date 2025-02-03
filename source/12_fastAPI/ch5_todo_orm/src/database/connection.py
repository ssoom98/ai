from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

# 오라클 url
DATABASE_URL = 'oracle+cx_oracle://scott:tiger@localhost:1521/?service_name=xe'

# 엔진 생성
engine = create_engine(DATABASE_URL, echo=True)
# 세션 클래스 생성
SessionFactory = sessionmaker(autocommit=False,
                              autoflush=False,
                              bind=engine)

def get_db():
  session = SessionFactory()
  try:
    yield session
  finally:
    session.close()