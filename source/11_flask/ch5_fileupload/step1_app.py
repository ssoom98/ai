from flask import Flask, render_template, request
from werkzeug.utils import secure_filename
import os
# 업로드 폴더 경로 설정(폴더없으면 폴더생성)
UPLOAD_FOLDER = './upload/'
if not os.path.exists(UPLOAD_FOLDER):
  os.makedirs(UPLOAD_FOLDER)

app = Flask(__name__)
# 파일 업로드 용량 제한(단위:바이트)
# 용량 제한이 없을 경우, 서버에서 매우 큰 용량을 업로드 할 403 error경우
# print(app.config)
app.config['MAX_CONTENT_LENGTH'] = 1024*1024*10 # 최대 업로드 용량

@app.route('/', methods=['get','post']) # 대소문자 가능
def upload_file():
  if request.method == 'POST': # 대문자만
    '''
    파라미터로 전달받은 파일을 upload 폴더에 저장하고 완료 페이지로 가기
    '''
    f = request.files['file']
    # 파일명에 서버에 영향을 미칠 문자가 포함된 경우 _로 교체
    safe_filename = secure_filename(f.filename)
    f.save(UPLOAD_FOLDER + safe_filename) # 파일 저장
    return render_template("check.html")
  return render_template("upload.html")

if __name__=='__main__':
  app.run(debug=True) # 서버 실행













