from flask import Flask
from ex5_predict import loaded_model,predict_apt_price

application = Flask(__name__)

@application.route('/')
def hello():
    return "<h1>Hello, Flask</h1>"
@application.route('/apt/<year>/<square>/<floor>')
def aptPrice(year,square,floor):
    answer = predict_apt_price(year,square,floor)
    return "예측 금액은{}".format(answer)

if __name__ =='__main__' :
    # debug =True : 코드가 변경될 때 마다 서버 자동 재시작
    application.run(host="127.0.0.1", port=80,debug=True)