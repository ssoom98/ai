from django.urls import path, register_converter
from . import views
from .converters import CodeConverter
register_converter(CodeConverter, "dddd")
app_name = "blog"
urlpatterns = [
  path("", views.index, name="index"),
  # localhost:8000/blog/2000
  #path("<int:post_id>/", views.detail, name='detail'), # int 컨버터를 사용
  path("<dddd:post_id>/", views.detail, name="detail"),
  path("json/", views.json_test, name="json"),
  path("excel/",views.excel_download, name="excel"),
  path("csv/",  views.pandas_csv_download, name='csv'),
  path("csvexcel/", views.pandas_excel_download, name="csvexcel"),
  path("redirect1/", views.get_redirect1, name="redirect1"),
  path("redirect2/", views.get_redirect2, name="redirect2"),
]










