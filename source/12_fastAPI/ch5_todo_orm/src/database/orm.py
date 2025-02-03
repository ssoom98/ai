from sqlalchemy.orm import declarative_base
from sqlalchemy import Column, Integer, String, Boolean

from database.connection import engine

Base = declarative_base()

class ToDo(Base):
  __tablename__ = 'todo'
  id       = Column(Integer, primary_key=True, autoincrement=True)
  contents = Column(String(256), nullable=False)
  is_done  = Column(Boolean, default=False, nullable=False)
  def __repr__(self): # 디버깅시 사용
    return f'ToDo<id:{self.id}, contents-{self.contents}, 수행여부-{self.is_done}>'

if __name__=='__main__':
  Base.metadata.create_all(bind=engine) # 테이블 없을 시 테이블 생성












