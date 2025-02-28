from myproject import settings
from django.shortcuts import render
import os
def upload_file(request):
  if request.method == 'POST':
    upload_file =request.FILES.get('file')
    print('★ 파일이름 :', upload_file.name)
    if upload_file:
      upload_dir = os.path.join(settings.BASE_DIR, '_media')
      os.makedirs(upload_dir, exist_ok=True)  # _media 폴더가 없으면 생성
      file_path = os.path.join(upload_dir, upload_file.name)
      with open(file_path, 'wb+') as f:
        for chunk in upload_file.chunks():
          f.write(chunk) # 업로드할 파일을 일정 크기로 조각
      return render(request, 'result.html')
  return render(request, 'fileupload.html')
import time
def predict(request):
  time.sleep(3)
  return render(request, 'predict.html',
                {'answer':'Hello, World!!'})
