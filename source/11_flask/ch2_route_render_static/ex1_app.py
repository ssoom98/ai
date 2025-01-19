from flask import Flask

app = Flask(__name__) # 앱 인스턴스 생성

@app.route('/') # @ : 데코레이터
def hello():
    return "<h1>HELLO WORLD</h1>"

if __name__=='__main__':
    app.run(debug=True) # 소스 수정시 서버 자동 재시작