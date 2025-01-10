# flask --app app_getNpost run --port=8090 -- reload
from flask import Flask,request,render_template
from models import Member
from filters import mask_password
app = Flask(__name__)
app.template_filter("mask_pw")(mask_password)

@app.route('/')
@app.route('/join',method=['GET','POST'])
def join():
    return '<h1>'+request.method+'방식</h1>'

if __name__=='__main__':
    app.run(debug=True)
