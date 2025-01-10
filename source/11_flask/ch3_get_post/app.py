from flask import Flask, render_template, request
app = Flask(__name__)

# @app.route('/user/<name>') # user/hong
# def user(hong):
@app.route('/user') #/user?name=hong
def user():
    name = request.args.get('name') # get방식 파라미터 값 받기
    return "<h1>User Name = " + name + "</h1>"

@app.route('/')
def index():
    return render_template("join_get/index.html")

if __name__=='__main__':
    app.run(debug=True)
# app.py 파일일 경우 터미널에서 flask run입력시 app.py파일 자동 실행
