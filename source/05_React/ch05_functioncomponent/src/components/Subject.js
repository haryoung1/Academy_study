import './Subject.css';
const Subject = props => { // 매개변수(props) 가 한개일땐 괄호를 안해도 됨. 두개이상이면 괄호 해야 됨
    // props.title = '수정불가, ReadOnly';
    return (
    <header className="Subject">
        <h1 onClick={() => {
            props.onChangeMode();
        }}>
            {props.title}
        </h1>
        {props.sub}
    </header>
    );
};
export default Subject;

// 맨 밑줄 export 필수