from django.contrib import admin
from blog.models import Post, Comment, Tag
# Register your models here.
admin.site.register(Post) # admin 페이지에서 post 테이블 액세스 가능
admin.site.register(Comment)
admin.site.register(Tag)
