import './App.css';
import React, {Component} from 'react';
import Subject from './components/Subject';
import TOC from './components/TOC';
import ReadContent from './components/ReadContent';
import Control from './components/Control';
import CreateContent from './components/CreateContent';
import UpdateContent from './components/UpdateContent';



class App extends Component{
  constructor(props) {
    super(props);
    this.max_content_id=3;
    this.state = {
      mode : 'welcome',
      slected_content_id : 1,
      subject : {title:'WEB', sub:'World wide web!'},
      contents : [
        {id:1, title:'HTML', desc: 'HTML is HyperText Markup Langauge.'},
        {id:2, title:'CSS',  desc: 'CSS is for design'},
        {id:3, title:'JavaScript', desc: 'JavaScript is for interacitive'}],
      welcome : {title: 'WELCOME', desc:'Hello, React !!!'},
    };
  } // 생성자

  getReadContent() { // this.state.selected_content_id id인 content안의 객체를 return
    for(var idx=0 ; idx<this.state.contents.length ; idx++) {
      var data = this.state.contents[idx];
      if(data.id === this.state.slected_content_id) {
        return data;
      } // if
    } // for 
  } // getReadContent

  getContent() {
    console.log('app render');
    var _title, _desc, _article = null;
    if(this.state.mode === 'welcome') {
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <ReadContent title = {_title} desc = {_desc}></ReadContent>
    }else if (this.state.mode === 'read') {
      var data = this.getReadContent();
      _article = <ReadContent title={data.title} desc={data.desc}></ReadContent>
    }else if (this.state.mode === 'create') {
      _article = <CreateContent onChangePage={function(_title, _desc) {
        // alert(_title + '/' + _desc); 테스트용
        // this.state.contents에 {id:max_content_id+1, title:_title, desc:_desc}를 push
        this.max_content_id ++;
        // this.state.contents.push( // state의 값을 변경하려면 setState() 함수 이용
        //   {id:this.max_content_id, title:_title, desc:_desc}
        // );
        // 방법1
        // var _contents = [ ...this.state.contents]; // 깊은복사
        // _contents.push({id:this.max_content_id, title:_title, desc:_desc});
        // 방법2
        // var _contents = this.state.contents.concat (
        //     {id:this.max_content_id, title:_title, desc:_desc}
        //   );
        // 방법3
        var _contents = Array.from(this.state.contents); // 깊은복사
        _contents.push({id:this.max_content_id, title:_title, desc:_desc});

        this.setState({
          contents : _contents,
        });
      }.bind(this)}></CreateContent>
    }else if (this.state.mode === 'update') {
      var _content = this.getReadContent();
      _article = <UpdateContent data={_content} onChangePage={function() {

      }}></UpdateContent>
    }
    return _article;
}
  render() {
    return (
      <div>
        <Subject title = {this.state.subject.title} 
                  sub  = {this.state.subject.sub}
                  onChangePage = {function() {
                    this.setState({
                      mode : 'welcome',
                    });
                  }.bind(this)}></Subject> 
        <TOC data = {this.state.contents} onChangePage={function(id) {
            this.setState({
              mode : 'read', slected_content_id : Number(id),
            });
          }.bind(this)}></TOC>
          <Control onChangePage={function(_mode) {
            this.setState({
              mode : _mode,
            });
          }.bind(this)}></Control>
          {this.getContent()}
      </div>
    );
  }
}

export default App;