from django.http import HttpResponse, Http404, JsonResponse
from django.shortcuts import render, get_object_or_404
from .models import Post

def index(request):
  post_list = Post.objects.all()
  # output = '<br>'.join([post.__str__() for post in post_list])
  # print(output)
  # return HttpResponse("<h1>Welcome Page</h1>" + output)
  return render(request,
                'blog/index.html',
                {'post_list':post_list})

def detail(request, post_id):
  # try:
  #   post = Post.objects.get(pk=post_id)
  # except Post.DoesNotExist:
  #   raise Http404("Post does not exist")
  post = get_object_or_404(Post, pk=post_id)
  # return HttpResponse(post.__str__())
  return render(request,
                'blog/detail.html',
                {'post':post})
def json_test(request):
  data = {
    'name':'hong Gildong',
    'age':22,
    'address':'서울시 관악구'
  }
  return JsonResponse(data,
                      json_dumps_params={
                        'ensure_ascii':False # 한글 깨지지 않으려고
                      })

def excel_download(request):
  filename = 'myproject.xlsx'
  with open(filename, 'rb') as f:
    response = HttpResponse(f, content_type='application/vnd.ms-excel')
    response['Content-Disposition']="attachment; filename={}".format(filename)
  return response

import pandas as pd
from io import StringIO, BytesIO
from urllib.parse import quote
def pandas_csv_download(request):
  df = pd.DataFrame([
    [100,90,80],
    [100,99,88],
    [99, 91,79],
  ], columns=['하나','둘','셋'])
  io = StringIO() # 스트링 버퍼
  df.to_csv(io, index=None)
  io.seek(0)
  filename = quote('pandas_csv.csv')
  response = HttpResponse(io, content_type='text/csv')
  response['Content-Disposition'] = "attachment; filename={}".format(filename)
  return response

def pandas_excel_download(request):
  df = pd.DataFrame([
    [100, 90, 80],
    [100, 99, 88],
    [99, 91, 79],
  ], columns=['하나', '둘', '셋'])
  io = BytesIO()  # 바이너리 버퍼
  df.to_excel(io, index=None)
  io.seek(0)
  # pip install openpyxl
  filename = quote('pandas_csv.xlsx')
  response = HttpResponse(io, content_type='application/vnd.ms-excel')
  response['Content-Disposition'] = "attachment; filename={}".format(filename)
  return response

from django.shortcuts import redirect
def get_redirect1(request):
  #return redirect('/blog') # 목록 페이지 경로
  #return redirect('blog:index')  # 목록 페이지 경로 name
  #return redirect('/blog/2')
  return redirect('blog:detail', post_id=2)

def get_redirect2(request):
  return redirect('http://google.com')






