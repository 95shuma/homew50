'use strict';

let comment = {
    id:1,
    userId:5, //ID юзера написавшего комментарий
    postId:3, //ID публикации к которой прикреплён комментарий
    text:"Great",
    print:function printAll() {
        console.log("Text: "+this.text);
    }
};
let post = {
    id:1,
    title:"Kyrgyzstan",
    description:"I live in Kyrgyzstan",
    imageURL:"http://placekitten.com/500/300",
    userId:5, //ID юзера опубликовавшего этот пост
    isLiked: false,
    print:function printAll() {
        console.log("Title: "+this.title+
            "\nDescription: "+this.description+
            "\nLiked status: "+this.isLiked);
    }
};

function clearLocalS() {
    localStorage.clear();
    window.location.href = "http://localhost:8000/";
}

function loadFun() {
    if(localStorage.length!=0){
        hideSplashScreen();
    } else {
        showSplashScreen();
    }
}

function showSplashScreen() {
    document.getElementById("page-splash").hidden = false;
    document.body.classList.add("no-scroll");
}

function hideSplashScreen() {
    document.getElementById("page-splash").hidden = true;
    document.body.classList.remove("no-scroll");
    f();
}

function showForm(id) {
    let form = document.getElementById("com"+id);
    if(form.classList.contains("add-comment-form")){
        form.classList.remove("add-comment-form");
    }
}

function showRegForm() {
    let form = document.getElementById("registration-form");
    if (form.classList.contains("registration-form")){
        form.classList.remove("registration-form");
        document.getElementById("login-form").classList.add("login-form");
    }
}

function showLogForm() {
    let form = document.getElementById("login-form");
    if (form.classList.contains("login-form")){
        form.classList.remove("login-form");
        document.getElementById("registration-form").classList.add("registration-form");
    }
}

// function hideForm() {
//     const form = document.getElementsByClassName("add-comment-form");
//     for (let i=0; i<form.length; i++){
//         form[i].hidden = true;
//     }
// }

function createCommentElement(comment) {
    let elem = document.createElement(`div`);
    elem.innerHTML = `<a href="#" class="muted">${comment.userId}</a>
	<p>${comment.text}</p>`;
    let att = document.createAttribute("class");
    att.value = "py-2 pl-3";
    elem.setAttributeNode(att);
    return elem;
}

let commentElement = createCommentElement(comment);

function addCommentElement(elem) {
    document.getElementById("comment").appendChild(elem);
}


function createPostElement(post) {
    let elem = document.createElement(`div`);
    elem.innerHTML = `
          <!-- image block start -->
          
          <div>
            <img class="d-block w-100 img" src="${post.imageURL}" alt="Post image" id="img.${post.id}"
            ondblclick="imgLike(id)(this.id)">
          </div>
          <!-- image block end -->
          <div class="px-4 py-3">
            <!-- post reactions block start -->
            <div class="d-flex justify-content-around">
              <!--<span class="h1 mx-2 text-danger">
                <i class="fas fa-heart"></i>
              </span>-->
              <span class="h1 mx-2 muted" id="likeimg.${post.id}" onclick="changeLike(this.id)">
                <i class="far fa-heart"></i>
              </span>
              <span class="h1 mx-2 muted">
                <i class="far fa-comment"></i>
              </span>
              <span class="mx-auto"></span>
              <span class="h1 mx-2 muted bookmark" id="bookmark.${post.id}" onclick="changeBookmark(this.id)">
                <i class="far fa-bookmark"></i>
              </span>
              <!--<span class="h1 mx-2 muted">
                <i class="fas fa-bookmark"></i>
              </span>-->
            </div>
            <!-- post reactions block end -->
            <hr>
            <!-- post section start -->
            <div>
              <p>${post.description}</p>
              </div>
            <!-- post section end -->
            <hr>
            <!-- comments section start -->
            <div>
              <div class="py-2 pl-3">
                <a href="#" class="muted">someusername</a>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid corrupti nesciunt, obcaecati fuga natus officiis.</p>
              </div>
              <div class="py-2 pl-3">
                <a href="#" class="muted">someusername</a>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid corrupti nesciunt, obcaecati fuga natus officiis.</p>
              <!-- </div>
              <button onclick="g()">Add Comm</button>
            </div> -->
            <button class="show-form" id="m.${post.id}" onclick="showForm(this.id)">Show form</button>
            <br>
            <div class="add-comment-form" id="comm.${post.id}">
                <form id="form.${post.id}" class="form" name="form" action="/comm" method="post" >
                    <input type="hidden" name="userId" value="${post.userId}">
                    <input type="hidden" name="postId" value="${post.id}">
                    <input type="hidden" name="commId" value="12345">
                    <input type="text" placeholder="Comment" name="comment">
                    <button type="button" id="rm.${post.id}" onclick="b_fun(this.id)">Add Comment</button>
                </form>
            </div>
            <!-- comments section end -->
          </div>`;
    let att = document.createAttribute("class");
    att.value = "card my-3";
    elem.setAttributeNode(att);
    return elem;
}

let postElement = createPostElement(post);

function addPostElement(elem) {
    document.getElementById("posts").appendChild(elem);
};

/*window.addEventListener('load',function () {
    view();
});*/

function changeLike(id) {
    let like = document.getElementById(id);
    if(like.classList.contains("muted")){
        like.classList.remove("muted");
        like.classList.add("text-danger");
        like.children[0].classList.remove("far");
        like.children[0].classList.add("fas");
    } else {
        like.classList.remove("text-danger");
        like.classList.add("muted");
        like.children[0].classList.remove("fas");
        like.children[0].classList.add("far");
    }
}

function imgLike(id) {
    let like = document.getElementById("like"+id);
    if(like.classList.contains("muted")){
        like.classList.remove("muted");
        like.classList.add("text-danger");
        like.children[0].classList.remove("far");
        like.children[0].classList.add("fas");
    } else {
        like.classList.remove("text-danger");
        like.classList.add("muted");
        like.children[0].classList.remove("fas");
        like.children[0].classList.add("far");
    }
}

function changeBookmark(id) {
    let bookmark = document.getElementById(id);
    if (bookmark.children[0].classList.contains("far")) {
        bookmark.children[0].classList.remove("far");
        bookmark.children[0].classList.add("fas");
    } else {
        bookmark.children[0].classList.remove("fas");
        bookmark.children[0].classList.add("far");
    }
}


/*window.addEventListener('load', f());

let a = document.getElementById("add");*/

//a.addEventListener("click",f());



async function getPosts() {
    const response = await fetch('http://localhost:8000/post/all',{
        headers : {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }

    });
    if (response.ok) { // если HTTP-статус в диапазоне 200-299
        // получаем тело ответа (см. про этот метод ниже)
        return await response.json();
    } else {
        alert("Ошибка HTTP: " + response.status);
    }
}

class Post{
    constructor(id,description,imageURL,userId) {
        this.id = id;
        this.description = description;
        this.imageURL = imageURL;
        this.userId = userId;
    }
}

class Comment {
    constructor(userId,postId,commId,comm) {
        this.userId = userId;
        this.postId = postId;
        this.commId = commId;
        this.comm = comm;
    }
}

async function getComments() {
    const response = await fetch('http://localhost:8000/comment/all',{
        headers : {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }

    });
    if (response.ok) { // если HTTP-статус в диапазоне 200-299
        // получаем тело ответа (см. про этот метод ниже)
        return await response.json();
    } else {
        alert("Ошибка HTTP: " + response.status);
    }
}

async function f(){
    let posts = await getPosts();

    for(let i=0; i<posts.length;i++){
        let post = new Post(posts[i].id,posts[i].description,posts[i].imagePath,posts[i].userId);
        let elem = createPostElement(post)
        console.log(post);
        document.getElementById("posts").appendChild(elem);
        g();
    }
};

async function g(){
    let comments = await getComments();

    for(let i=0; i<comments.length;i++){
        let comm = new Comment(comments[i].userId,
            comments[i].postId,comments[i].id,
            comments[i].text);
        let elem = createCommentElement(comm)
        console.log(comm);
        addCommentElement(elem)
    }
};

function a_fun(){
        const candidateForm = document.getElementById("form");
        let data = new FormData(candidateForm);

        fetch("http://localhost:8000/post", {
            method: 'POST',
            body: data
        }).then(r => r.json()).
        then(data => {window.location.href = "http://localhost:8000/"});
};

function b_fun(id) {
    const comForm = document.getElementById("fo" + id);
    if(comForm.classList.contains("form")){
        console.log("hi");
    }
    let data = new FormData(comForm);

    fetch("http://localhost:8000/comm", {
        method: 'POST',
        body: data
    }).then(r => r.json()).then(data => {
        window.location.href = "http://localhost:8000/"
    });
}

window.addEventListener('load', function () {

    loadFun();

    const registrationForm = document.getElementById('registration-form');
    registrationForm.addEventListener('submit', onRegisterHandler);

    function onRegisterHandler(e) {
        e.preventDefault();
        const form = e.target;
        const data = new FormData(form);
        const userJSON = JSON.stringify(Object.fromEntries(data));
        createUser(data);
    }

    const baseUrl = 'http://localhost:8000';

    async function createUser(userJSON) {
        const settings = {
            method: 'POST',
            body: userJSON
        };

        const response = await fetch(baseUrl + '/user/registration', settings);
        const responseData = await response.json();

        console.log(responseData);

        window.location.href = baseUrl;
    }

    const loginForm = document.getElementById('login-form');
    loginForm.addEventListener('submit', onLoginHandler);

    function onLoginHandler(e) {
        e.preventDefault();
        const form = e.target;
        const userFormData = new FormData(form);
        const user = Object.fromEntries(userFormData);
        saveUser(user);
        fetchAuthorised(baseUrl+"/user/login");
        window.location.href = baseUrl;
    }

    function fetchAuthorised(url, options) {
        const settings = options || {}
        return fetch(url, updateOptions(settings)).then(r => r.json()).then(data => {window.location.href = baseUrl});
    }

    function updateOptions(options) {
        const update = { ...options };
        update.mode = 'cors';
        update.headers = { ... options.headers };
        update.headers['Content-Type'] = 'application/json';
        const user = restoreUser();
        if(user) {
            update.headers['Authorization'] = 'Basic ' + btoa(user.username + ':' + user.password);
        }
        return update;
    }

    function saveUser(user) {
        const userAsJSON = JSON.stringify(user)
        localStorage.setItem('user', userAsJSON);
    }

    function restoreUser() {
        const userAsJSON = localStorage.getItem('user');
        const user = JSON.parse(userAsJSON);
        return user;
    }
});