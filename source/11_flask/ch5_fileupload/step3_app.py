# 파일첨부화면(home.html) : form태그
                # + upload에 첨부된 파일 list(파일다운로드,파일삭제)
from os import access

from flask import Flask, render_template
from flask import send_file # 다운로드시 필요
from flask import redirect, url_for # 삭제 후 '/'요청경로로 redirect
from flask_wtf import FlaskForm
from flask_wtf.file import FileField, FileRequired
from werkzeug.utils import secure_filename

import os
import datetime

app = Flask(__name__)
# print(app.config)
app.config['SECRET_KEY'] = 'secret'

class FileForm(FlaskForm):
  files = FileField(validators=[FileRequired()])

def stamp2real(stamp):
  return datetime.datetime.fromtimestamp(stamp)

def info(filename):
  create = stamp2real(os.path.getctime(filename))
  modify = stamp2real(os.path.getmtime(filename))
  access = stamp2real(os.path.getatime(filename))
  tempsize = os.path.getsize(filename)
  size = ''
  if tempsize < 1024*1024:
    size = '{:.3f}KB'.format( tempsize/ 1024 )
  else:
    size = '{:.3f}MB'.format( tempsize / (1024*1024) )
  return create, modify, access, size

@app.route('/', methods=['GET','POST'])
def main_page():
  form = FileForm()
  if form.validate_on_submit(): # POST방식으로 유효한 form 데이터가 들어왔는지
    f = form.files.data
    filepath = './upload/' + secure_filename(f.filename)
    f.save(filepath)
    create, modify, access, size = info(filepath)
    fileinfo = {'ctime':create,
                # 'modify':modify,
                # 'access':access,
                'size':size}
    return render_template('check.html',
                           fileinfo=fileinfo)
  # GET방식이거나 form 데이터가 유효하지 않은 경우
  # upload 폴더의 파일 정보들을 home.html로 render
  filelist = os.listdir('upload')
  # print(['upload/'+filename for filename in filelist])
  infos = []
  for filename in filelist:
    create, modify, access, size = info('upload/'+filename)
    fileinfo = {
      'name':filename,
      'create':create,
      'modify':modify,
      'size':size
    }
    infos.append(fileinfo)
  return render_template('home.html',
                         form=form,
                         infos = infos)

if __name__=='__main__':
  app.run(debug=True)





