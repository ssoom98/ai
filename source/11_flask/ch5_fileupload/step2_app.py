# 폼 유효성 검사 : pip install flask_wtf
  # 쉽고 유연한 폼 적용하여 유효성 검증
  # CSRF 보호(스크립트가 form데이터를 날렸는지, 사람이 날렸는지 감지)

from flask import Flask, render_template#, request
from flask_wtf import FlaskForm # 유효성 검사를 위한 form 객체
from flask_wtf.file import FileField, FileRequired
from werkzeug.utils import secure_filename
import os
import datetime

app = Flask(__name__)
# print(app.config)
# 유효성 검사 중 CSRF 공격을 방지하기 위한 토큰 생성
app.config['SECRET_KEY'] = 'secret' # 유추하기 어려운 임의의 문자들

class FileForm(FlaskForm):
  files = FileField(validators=[FileRequired()])

def stamp2real(stamp):
  'stamp(1970.1.1~특정시점까지 초수)를 입력받아 특정시점을 가독성높은 문자'
  return datetime.datetime.fromtimestamp(stamp)

def info(filename):
  '파일 생성시간, 마지막수정시간, 마지막액세스시간, 파일사이즈를 return'
  ctime = stamp2real(os.path.getctime(filename))
  mtime = stamp2real(os.path.getmtime(filename))
  atime = stamp2real(os.path.getatime(filename))
  size = os.path.getsize(filename)
  return ctime, mtime, atime, size

@app.route('/', methods=['GET','POST'])
def upload_file():
  form = FileForm()
  if form.validate_on_submit(): # 폼데이터 유효한지, POST 요청으로 들어왔는지
    'form에서 받은 파일을 저장하고 check.html 로'
    f = form.files.data
    safe_filename = secure_filename(f.filename)
    f.save('./upload/' + safe_filename)
    '저장된 파일에 대한 정보'
    ctime, mtime, atime, size = info('./upload/'+safe_filename)
    fileinfo = {'ctime':ctime,
                'mtime':mtime,
                'atime':atime}
    if size < 1024*1024 : # size가 1MB가 안되는 경우
      fileinfo['size'] = '{:.3f}KB'.format(size/1024)
    else:
      fileinfo['size'] = '{:.3f}MB'.format(size / (1024*1024) )

    return render_template('check.html',
                           fileinfo=fileinfo)
  return render_template('upload.html',
                           form=form)

if __name__=='__main__':
  app.run(debug=True, port=80)












