'use strict';

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
function showSplashScreen() {
    document.getElementById("page-splash").hidden = false;
    document.body.classList.add("no-scroll");
}

function hideSplashScreen() {
    document.getElementById("page-splash").hidden = true;
    document.body.classList.remove("no-scroll");
    setTimeout(() => {  console.log("World!"); }, 3000);
    view();
    f();

}

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
            <img class="d-block w-100 img" src="${post.imageURL}" alt="Post image">
          </div>
          <!-- image block end -->
          <div class="px-4 py-3">
            <!-- post reactions block start -->
            <div class="d-flex justify-content-around">
              <!--<span class="h1 mx-2 text-danger">
                <i class="fas fa-heart"></i>
              </span>-->
              <span class="h1 mx-2 muted like">
                <i class="far fa-heart"></i>
              </span>
              <span class="h1 mx-2 muted">
                <i class="far fa-comment"></i>
              </span>
              <span class="mx-auto"></span>
              <span class="h1 mx-2 muted bookmark">
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
              </div>
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

function view(){
    let like = document.getElementsByClassName("like");
    for (let i=0; i<like.length;i++){
        like[i].addEventListener('click', function () {
            if(like[i].classList.contains("muted")){
                like[i].classList.remove("muted");
                like[i].classList.add("text-danger");
                like[i].children[0].classList.remove("far");
                like[i].children[0].classList.add("fas");
            } else {
                like[i].classList.remove("text-danger");
                like[i].classList.add("muted");
                like[i].children[0].classList.remove("fas");
                like[i].children[0].classList.add("far");
            }
        });
    }


    let img = document.getElementsByClassName("img");
    for (let i=0;i<img.length;i++){
        img[i].addEventListener('dblclick', function (){
            if(like[i].classList.contains("muted")){
                like[i].classList.remove("muted");
                like[i].classList.add("text-danger");
                like[i].children[0].classList.remove("far");
                like[i].children[0].classList.add("fas");
            } else {
                like[i].classList.remove("text-danger");
                like[i].classList.add("muted");
                like[i].children[0].classList.remove("fas");
                like[i].children[0].classList.add("far");
            }
        });
    }

    let bookmark = document.getElementsByClassName("bookmark");
    for (let i=0; i<bookmark.length;i++) {
        bookmark[i].addEventListener('click', function () {
            if (bookmark[i].children[0].classList.contains("far")) {
                bookmark[i].children[0].classList.remove("far");
                bookmark[i].children[0].classList.add("fas");
            } else {
                bookmark[i].children[0].classList.remove("fas");
                bookmark[i].children[0].classList.add("far");
            }
        });
    } };

view();

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
    constructor(id,description,imageURL) {
        this.id = id;
        this.description = description;
        this.imageURL = imageURL;
    }
}

async function f(){
    let posts = await getPosts();
    //let index = posts.length - 1;
    //console.log(posts);

    for(let i=0; i<posts.length;i++){
        let post = new Post(posts[i].id,posts[i].description,posts[i].imagePath);
        let elem = createPostElement(post)
        console.log(post);
        document.getElementById("posts").appendChild(elem);
    }

    /*let addedPost = {
        id: posts[index].id,
        description: posts[index].description,
        imageURL:posts[index].imagePath
    };
    console.log(addedPost);
    document.getElementById("posts").append(createPostElement(addedPost));*/
};

function a_fun(){
    const saveButton = document.getElementById("addPost");
    saveButton.addEventListener("click", function() {
        const candidateForm = document.getElementById("form");
        let data = new FormData(candidateForm);

        fetch("http://localhost:8000/post", {
            method: 'POST',
            body: data
        }).then(r => r.json()).
        then(data => {window.location.href = "http://localhost:8000/"});
    });
};



