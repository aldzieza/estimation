const apiUrl = 'https://jsonplaceholder.typicode.com';


async function fetchPosts(){
// tutaj w nawiasach wpisujemy url , {method: 'GET'});
    try{
        const response = await fetch('https://jsonplaceholder.typicode.com/posts');
        // jeżeli wyniki jest NOK

        if (!response.ok){
            throw new Error('Failed to fetch posts:  ${response.status}');
        }

        return response.json();


    }catch(e){
        console.log(e);
    }
}


function listPosts(postContainerElementId){
    const postContainerElement = document.getElementById(
        postContainerElementId
    );
    if(!postContainerElement){
        return;
    }
    // const posts= await fetchPosts();
    fetchPosts().then((posts)=> {
        if(!posts){
            postContainerElement.innerHTML='No posts fetched.';
            return;
        }
        for(const post of posts){
            postContainerElement.appendChild(postElement(post));
        }
    })
        .catch((e)=>{
            console.log(e);
        });
}
// tworzenie anchor elementu
function postElement(post){
    const anchorElement =document.createElement('a');
    anchorElement.setAttribute('href', 'https://jsonplaceholder.typicode.com/posts/${post.id}');
    anchorElement.setAttribute('target', '_blank');
    anchorElement.innerText=post.title;

    const postTitleElement =document.createElement('h3');
    postTitleElement.appendChild(anchorElement);




    return postTitleElement;
}
