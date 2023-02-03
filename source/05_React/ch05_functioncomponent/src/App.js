import Subject from "./components/Subject"; 
import TOC from "./components/TOC";
import Control from "./components/Control";
import ReadContent from "./components/ReadContent";
import React, {useState} from 'react'; 
import CreateContent from "./components/CreateContent";
import UpdateContent from "./components/UpdateContent";

function App() {
  // // let mode = 'read';
  // const _mode = useState('read');
  // console.log(_mode); 
  let [mode, setMode] = useState('read');
  let [nextId, setNextId] = useState(4);
  let [selectedId, setSelectedId] = useState(2); // 4
  let [contents, setContents] = useState([ // 1
    {id:1, title:'HTML', body: 'HTML is HyperText Markup Langauge.', },
    {id:2, title:'CSS',  body: 'CSS is for design.', },
    {id:3, title:'JavaScript', body: 'JavaScript is for interactive 배고파', },
  ]);
  let subject = {title : 'WEB', sub:'World wide web!'};
  let welcome = {title:'WELCOME', body:'Hello, React!!'};
  let _title,_body,_article = null;

  if (mode === 'welcome') {
    console.log(mode);
    _title = welcome.title;
    _body = welcome.body;
    _article = <ReadContent title={_title} body={_body}></ReadContent>
  }else if (mode === 'read') {
    _title = contents[0].title;
    _body = contents[0].body;
    for (var i=0; i<contents.length ; i++) {
      if (contents[i].id === selectedId) {
        _title = contents[i].title;
        _body = contents[i].body;
        break;
      }
    }
    _article = <ReadContent title={_title} body={_body}></ReadContent>

  }else if (mode === 'create') {
    _article = <CreateContent onCreate={(_title, _body)=>{
    // maxId++ ; {id:4, title:_title, body:_body} 객체를 contents에 추가
    let _contents = Array.from(contents); // 깊은 복사한 _contents에 push
    _contents.push({id:nextId, title:_title, body:_body});
      setContents(_contents);
      setSelectedId(nextId);
      setNextId(nextId+1);
    }}></CreateContent>

  }else if (mode === 'update') {
    let _content;
    for(var idx=0 ; idx<contents.length ; idx ++) {
      if(contents[idx].id === selectedId) {
        _content = contents[idx];
        break;
      }
    } // for
    _article = <UpdateContent data={_content} onUpdate={(_title, _body)=>{
      // alert(_title + '/' + _body);
      // contents를 복제한 _contents의 id가 selectedId랑 같은 contents안의 객체를 변경
      let _contents = [...contents];
      for (var idx=0 ; idx<_contents.length ; idx++) {
        if (_contents[idx].id === selectedId) {
          _contents[idx] = {id:selectedId, title:_title, body:_body};
          // _contents[idx].title = _title;
          // _contents[idx].body  = _body;
          break
        } // if
      } // for
      setContents(_contents) 
      setMode('read');
    }}></UpdateContent>
  }

  return (
    <>
    <Subject title={subject.title} sub={subject.sub}
            onChangeMode={()=>{
              // mode = 'welcome';
              setMode('welcome');
            }}
    ></Subject>
    <TOC data={contents} onChangeMode={(_id) => {
      setSelectedId(_id);
      setMode('read');
    }}></TOC>
    <Control onChangeMode={(_mode)=>{
      if (_mode === 'delete') {
        if(window.confirm('삭제 후 복구는 불가능 합니다. 삭제 하시겠습니까?')) {
          // delete 작업
          let _content = [...contents];
          for (let idx=0 ; idx<contents.length ; idx ++) {
            if(_content[idx].id === selectedId) {
              _content.splice(idx, 1); // idx번째 1개 제거
              let _id;
              if (_content.length>0) {
                _id = _content[_content.length-1].id; // 제일 작은 id값을 selectedId
              }else {
                _id = 0;
              } // if
              setContents(_content);
              setMode('read');
              setSelectedId(_id);
              break;
            } // if
          } // for
        } // if - confirm
      }else {
        setMode(_mode);
      }
    }}></Control>
    {_article}
    </>
  );
}
export default App;

// 각 펑션을 만들고 js 파일로 분리한다 그 다음 import
// 각 파일안에 기능 수정 및 추가 props
// App부터 Strick mode 선언 해놓았기 때문에 변수선언 필수
// subject 하고, TOC 는 배열