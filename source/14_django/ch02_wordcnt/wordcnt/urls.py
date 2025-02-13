# wordcnt 패키지안의 urls 모듈

# /wordcnt        (name=wordcnt:wordinput) 단어입력
# /wordcnt/result (name=wordcnt:result) 결과
# /wordcnt/about  (name=wordcnt:about) 도움말
from django.urls import path
from wordcnt import views
app_name = 'wordcnt'
urlpatterns = [
  path('', views.wordinput, name="wordinput"),
  path('about/',  views.about, name="about"),
  path('result/', views.result, name="result"),
]