from django import forms
from django.core.validators import MinLengthValidator
from django.core.validators import MinValueValidator
from django.core.validators import MaxValueValidator
from .models import Book

class BookForm(forms.Form):
  title = forms.CharField(label = '책제목')
  author = forms.CharField(label = '글쓴이', validators=[MinLengthValidator(3)])
  publisher = forms.CharField(label='출판사', required=False)
  sales = forms.IntegerField(initial=1000,
                             validators=[MinValueValidator(0),
                                         MaxValueValidator(1000000)])
  def save(self, commit=True):
    book = Book(**self.cleaned_data)
    if commit:
      book.save()
    return book

class BookModelForm(forms.ModelForm): # ModelForm안에 save() 있음
  class Meta:
    model = Book
    fields = ['title','author','publisher','sales']
    #fields = '__all__'