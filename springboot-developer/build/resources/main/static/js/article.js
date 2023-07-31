const deleteButton = document.getElementById('delete-btn')
const modifyButton = document.getElementById('modify-btn')
const createButton = document.getElementById('create-btn')

if (deleteButton) {
  deleteButton.addEventListener('click', e => {
    let id = document.getElementById('article-id').value
    fetch(`/api/articles/${id}`, {
      method: 'DELETE'
    })
      .then(() => {
        alert('삭제가 완료되었습니다.')
        location.replace('/articles')
      })
  })
}

if (modifyButton) {
  modifyButton.addEventListener('click', e => {
    let params = new URLSearchParams(location.search)
    let id = params.get('id')

    fetch(`/api/articles/${id}`, {
      method: 'PUT',
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: document.getElementById('title').value,
        content: document.getElementById('content').value
      })
    })
      .then(() => {
        alert('수정이 완료되었습니다.')
        location.replace(`/articles/${id}`)
      })
  })
}

if (createButton) {
  createButton.addEventListener("click", e => {
    apiCall("articles", "POST").then(() => {
      alert("등록 완료되었습니다.")
      location.replace("/articles")
    })
  })
}

function apiCall(url, method){
  return fetch("/api/" + url, {
    method: method,
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      title: document.getElementById("title").value,
      content: document.getElementById("content").value
    })
  })
}