from flask import Flask, render_template, url_for

app = Flask(__name__)

@app.route('/')
def hello():
    return render_template("05_index.html")

@app.route('/profile/<name>/<int:age>') #/profile/홍길동/33
def get_profile(name, age):
    return render_template("05_profile.html",
                           name=name,
                           age=age)

if __name__=='__main__':
    with app.test_request_context():
        print('※', url_for('hello'))
        print('※', url_for('get_profile', name='HONG', age=22))
    app.run(debug=True)












