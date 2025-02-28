from django.views.generic import ListView, CreateView
from django.views.generic import DetailView, UpdateView,DeleteView
from article.models import Article
from django.urls import reverse_lazy

# Create your views here.
article_list =ListView.as_view(model=Article)
article_new = CreateView.as_view(model=Article, fields='__all__')
article_detail = DetailView.as_view(model=Article)
article_edit = UpdateView.as_view(model=Article, fields='__all__')
article_delete = DeleteView.as_view(model=Article,
                                    success_url=reverse_lazy('article:list'))
