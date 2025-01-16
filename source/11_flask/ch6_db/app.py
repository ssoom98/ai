from flask  import Flask, render_template # 요청경로를 html로 응답
from flask import jsonify # 요청경로를 json으로 응답
from flask import Response,json # json응답할 경우 한글깨짐 해결
import cx_Oracle

app = Flask(__name__)

dsn = cx_Oracle.makedsn('localhost',1521,'xe')
conn = cx_Oracle.connect(user='scott',password='tiger',dsn=dsn)

@app.route('/')
def get_emps():
    cursor = conn.cursor()
    sql = "SELECT * FROM EMP"
    cursor.execute(sql)
    emps = cursor.fetchall()
    cursor.close()
    return render_template("emps.html",emps=emps)

@app.route('/detail_json/<ename>')
def json_response(ename):
    cursor = conn.cursor()
    sql = "SELECT * FROM EMP WHERE ENAME=UPPER(:ename)"
    cursor.execute(sql,{'ename':ename})
    emps = cursor.fetchall()
    keys = [desc[0] for desc in cursor.description]
    cursor.close()
    result = {}
    if emps:
        for key, data in zip(keys, emps[0]):
            result[key] = data
        return jsonify(result)
    else:
        #return jsonify({'result':'Not Found!'})
        response = Response(json.dumps({'result':'못찾음'},ensure_ascii=False))
        return response
if __name__=='__main__':
    app.run(debug=True)

