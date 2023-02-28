import React, {Component} from 'react';
class TOC extends Component {
    shouldComponentUpdate(newProps) {
        console.log('shouldComponentUpdate', newProps.data, this.props.data);
        if (newProps.data === this.props.data) {
            return false;
        }
        return true;
    }
    render() {
        console.log('TOC render');
        var lists = [];
        var data = this.props.data;
        for (var i=0 ; i<data.length ; i++) {
            lists.push(
                <li key={data[i].id}>
                <a href = {data[i].id + ".html"} 
                data-id={data[i].id}
                onClick={function(event){
                event.preventDefault();
        // console.log(event.target.dataset.id);
        // this.props.onChangePage();
        this.props.onChangePage(event.target.dataset.id);
        }.bind(this)}>
        {data[i].title} 
        </a>
        </li>
        );
    }
    return (
        <nav>
            <ul>
                {lists}
            </ul>
        </nav>
        );
    }
}
export default TOC;