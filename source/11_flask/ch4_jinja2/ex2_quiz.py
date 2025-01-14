from flask import Flask, render_template,request

app = Flask(__name__)

@app.route('/', methods=['GET','POST'])
def index():
  if request.method=='GET':
    no = request.args.get("no") # 파라미터 못받으면 None
  elif request.method=='POST':
    no = request.form['no'].strip()
  return render_template("2_quiz.html",
                         no=no)

if __name__ == '__main__':
  app.run(debug=True)