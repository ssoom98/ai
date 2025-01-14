from flask import Flask
from ex5_predict import loaded_model, predict_apt_price

application = Flask(__name__)

@application.route('/')
def hello():
    return "<h1>Hello, Flask!</h1>"

@application.route('/apt/<year>/<square>/<floor>') # /apt/2010/105/8
def aptPrice(year, square, floor):
    answer = predict_apt_price(year, square, floor)
    return "<h1>예측금액은 {}</h1>".format(answer)

if __name__=="__main__":
    # debug=True : 코드가 변경될 때마다 서버 자동 재시작
    application.run(host="127.0.0.1", port=80, debug=True)








