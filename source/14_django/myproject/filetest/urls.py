from django.urls import path
from . import views
# file/ DB에 저장안 될 파일 첨부
# file/prediect
app_name = "file"
urlpatterns = [
  path("", views.upload_file, name="upload_file"),
  path("predict/", views.predict, name="predict"),
]