from importlib.resources import contents

from connection import conn
from src.models import ToDoRequest


def get_todos()->list[dict]:
  cursor = conn.cursor()
  sql = 'SELECT * FROM TODO ORDER BY ID'
  cursor.execute(sql)
  results = cursor.fetchall() # SQL 결과를 튜플 list
  cursor.close()
  todos = []
  for result in results:
    todos.append({'id':result[0],
                  'contents':result[1],
                  'is_done':result[2]})
  return todos

def get_todo(todo_id:int)->dict:
  cursor = conn.cursor()
  sql = 'SELECT * FROM TODO WHERE ID = :id'
  cursor.execute(sql,{'id':todo_id})
  result = cursor.fetchone() # 결과를 한행 튜플로 받음
  cursor.close()
  if result:
    return{'id':result[0],
           'contents':result[1],
           'is_done':result[2]}
  return {}

def create_todo(todo:ToDoRequest)->str:
  cursor = conn.cursor()
  print('추가될 내용 :', todo.contents, todo.is_done)
  sql = 'INSERT INTO TODO (ID, CONTENTS, IS_DONE) VALUES (TODO_SQ.NEXTVAL, :contents,:is_done)'
  cursor.execute(sql,{'contents':todo.contents,
                      'is_done':todo.is_done})
  conn.commit()
  result = cursor.rowcount # sql문이 수행된 행수
  cursor.close()
  if result:
    return '추가성공'
  return  '추가실패'

def update_todo(id:int,contents:str,is_done:bool)->str:
  cursor = conn.cursor()
  sql = 'UPDATE TODO SET CONTENTS=:contents, IS_DONE=:is_done WHERE ID=:id'
  cursor.execute(sql,{'id':id,
                      'contents':contents,
                      'is_done':is_done})
  conn.commit()
  result = cursor.rowcount
  cursor.close()
  if result :
    return f'{id}-{contents} 수정성공'
  return '수정 실패'

def delete_todo(todo_id:int):
  cursor = conn.cursor()
  sql ='DELETE FROM TODO WHERE ID=:id'
  cursor.execute(sql,{'id':todo_id})
  conn.commit()
  result = cursor.rowcount
  cursor.close()
  if result:
    return  f'{id}-{contents}삭제 성공'
  return ''
if __name__=='__main__':
  todo= ToDoRequest()
  todo.contents='추가할 todo'
  todo.is_done = True
  print('3. create :', create_todo(todo))
  print('1. 목록 :', get_todos())
  print('2. 상세 :', get_todo(1))
  print('2. 상세 :', get_todo(9))
  print('4. update:', update_todo(1,'이걸로바꿔',True))
  print('5. delete:', delete_todo(1))
