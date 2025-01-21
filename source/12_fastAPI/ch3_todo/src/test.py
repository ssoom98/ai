import os
filepath = os.path.abspath(__file__)
print('현 파일의 절대 경로: ' ,filepath)
BASE_DIR=os.path.dirname(filepath)
print('현 폴더의 절대 경로:',BASE_DIR)
static_folder = os.path.join(BASE_DIR,'../static')
print('static 절대경로:', static_folder)

todo_data={
    1:{
        'id':1,
        'contents':'딥러닝',
        'is_done':True
    },
    2:{
        'id':2,
        'contents':'fastAPI공부',
        'is_done':False
    },
    3:{
        'id':3,
        'contents':'머신러닝 공부',
        'is_done':False
    },
    4:{
        'id':4,
        'contents':'장고 공부',
        'is_done':False
    }

}
print(max(todo_data.keys())+1)
