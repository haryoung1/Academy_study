import { Component } from "react";

class CreateContent extends Component {
    render() {
        return (
            <article>
                <h2>CREATE</h2>
                <form action="/create_process" method="get" onSubmit={function(event){
                    event.preventDefault();
                    // console.log(event.target.desc.value);
                    // debugger;
                    this.props.onChangePage(
                        event.target.title.value,
                        event.target.desc.value
                        );
                        event.target.title.value = '';
                        event.target.desc.value = '';
                }.bind(this)}>
                    <p><input type="text" name="title" placeholder="title"></input></p>
                    <p><textarea name="desc" placeholder="desc"></textarea></p>
                    <p><input type="submit" value="추가"></input></p>
                </form>
            </article>
        );
    }
}

export default CreateContent;