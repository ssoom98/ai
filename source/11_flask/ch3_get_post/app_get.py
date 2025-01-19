from flask import Flask, render_template, request
from models import Member
from filters import mask_password

app = Flask(__name__)
app.template_filter("mask_password")(mask_password)

# @app.route('/user/<name>') # /user/hong
# def user(name):
@app.route('/user') #/user?name=hong
def user():
    name = request.args.get('name') # get방식 파라미터 값 받기
    return "<h1>User Name = " + name + "</h1>"

@app.route('/')
def index():
    return render_template("join_get/index.html")

@app.route('/join_form')
def join_form():
    return render_template("join_get/join.html")

@app.route('/join')
def join():
    name = request.args.get("name") #get
    id   = request.args.get("id")
    pw   = request.args.get("pw")
    addr = request.args.get("addr")
    member = Member(name, id, pw, addr)
    return render_template("join_get/result.html",
                           member=member)

@app.route('/welcome')
def welcome():
    name = request.args.get("name") # get방식으로 받은 파라마터 값
    value= request.args.get("value")
    print(type(value))
    return render_template("welcome.html",
                           name=name,
                           value=value)

# @app.template_filter("mask_password")
# def mask_password(password):
#     return '*'*len(password)

if __name__=='__main__':
    app.run(debug=True, port=8090)
# app_get.py 파일일 경우 터미널에서 flask run --reload입력시 app.py파일 자동 실행
    # py파일이 변경될 때마다 서버 자동 재시작
    # templates나 static 파일이 변경될 때 서버 자동 재시작이 안 되기도 함










