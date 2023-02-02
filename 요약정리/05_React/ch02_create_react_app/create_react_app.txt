React 란 ?

사용자 정의 태그를 만들어 주는 기술 중 하나, 이를 component라 한다.

Component의 장점 : ①가독성 ②재사용성 ③유지보수 용이성

-- 환경 구축 --
소스 폴더를 만들어 그 폴더에서 cmd 창에서 create-react-app . 실행
폴더를 vs code에서 실행 : npm run start 또는 npm start 
public의 index.html이 브라우저에서 열림
src의 index.js가 실행 -> app.js 로 가는 소스를 수정


F12의 Network 탭을 열고, 캐시비우기 및 강력 새로고침하면 2.7M다운로드(react의 여러 기능 포함)
npm run build를 하면 build 폴더 생성됨
npm install –g serve ; npm을 통해 설치된 간단한 웹 서버 가능하도록(serve명령을 사용가능하도록)
npx serve –s build : build가 root로 함
