import pandas as pd          # csv 파일 read
import statsmodels.api as sm # 회귀분석 모델 생성
import joblib     # pkl 모델 저장하거나 load

df = pd.read_csv('../data/trade_apt_api.csv', encoding='cp949')
x = df[['건축년도','전용면적','층']]
X = sm.add_constant(x) # 상수항(1) 추가하기 위한 add_constant함수
y = df['거래금액']
model = sm.OLS(y, X).fit()
# 모델 저장
joblib.dump(model, '../model/ex1_apt_price_regression.pkl')