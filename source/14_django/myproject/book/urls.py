from django.urls import path
from . import views
'''
/book/ => book_list
/book/new => book추가(book_new)
/book/1/edit => 1번 article 수정(book_edit)
/book/1/delete => 1번 article 삭제(book_delete)
'''
app_name = "book"
urlpatterns = [
  path("", views.book_list, name="list"),
  path("new/", views.book_new, name="new"),
  path("<int:pk>/edit/", views.book_edit, name="edit"),
  path("<int:pk>/delete/", views.book_delete, name="delete"),
]