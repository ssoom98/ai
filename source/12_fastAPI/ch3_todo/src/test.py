import os
filepath = os.path.abspath(__file__)
print('현 파일의 절대 경로: ' ,filepath)
BASE_DIR=os.path.dirname(filepath)
print('현 폴더의 절대 경로:',BASE_DIR)
static_folder = os.path.join(BASE_DIR,'../static')
print('static 절대경로:', static_folder)
