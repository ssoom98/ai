from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.
def index(request):
    context = {'msg':'wordCount welcome page',
               'greeting':'Hello,Django'}
    return render(request=request,
                  template_name='home/index.html',
                  context=context)
def test(request):
    return HttpResponse('''<h1>테스트페이지</h1>
            <button onclick="location='/'">뒤로가기</button>     
    ''')

def showIntId(request:HttpResponse,id:int):
    msg = '숫자 ID는 ' + str(id)
    id_type = '숫자입니다'
    return render(request,
                  'home/showId.html',
                  {'msg':msg,'type':id_type})

def showStrId(request:HttpResponse,id:str):
    msg = '문자 ID는 ' + id
    id_type = '문자입니다'
    return render(request,
                  'home/showId.html',
                  {'msg':msg,'type':id_type})