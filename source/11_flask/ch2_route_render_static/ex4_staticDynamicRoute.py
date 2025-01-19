# http://localhost:8090/join?id=abc&pw=111 (static Route)
# http://localhost:8090/join/abc/111 (Dynamic Route)
from flask import Flask, url_for
app = Flask(__name__)
# 라우팅 : URL을 특정 함수에 연결하는 작업
@app.route('/hello') # 정적 라우팅
def hello():
    return "<h1>Hello, World!</h1>"

# 동적 라우팅:상황에 따른 변화하는 URL을 함수와 연결하는 작업
@app.route('/profile/<username>')
def get_profile(username):
    return "<h1>profile : " + username + "</h1>"

if __name__=='__main__':
    with app.test_request_context():
        print('※※※', url_for('hello'))
        print('※※※', url_for('get_profile',
                             username='hong'))
    app.run(debug=True, port=80)









