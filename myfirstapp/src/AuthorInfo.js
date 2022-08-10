import React, { Component } from 'react';

class AuthorInfo extends React.Component {
    render(){
     let {author, email} = this.props;
     return (<div>
        <p>Author: {author}</p>
        <p><a href="mailto:{email}">{email}</a></p>
      </div>);
    }
   }	

   export default AuthorInfo;