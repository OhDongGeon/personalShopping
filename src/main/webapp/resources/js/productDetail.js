const productId = document.getElementById('productId').value;

// 메인 이미지 변경
$(document).ready(function () {
  $('.pt').on('mouseover', function () {
    var imgSrc = $(this).attr('data-target');
    $('.product__big__img').attr('src', imgSrc);
  });
})


// 페이지 로드 시 첫 페이지 리뷰 로딩
$(document).ready(function () {
  findReviews(productId, 1, 5);
});


// 리뷰 조회
function findReviews(productId, page, pageSize) {

  $.ajax({
    url: `/reviews/products/` + productId + `?page=` + page + `&pageSize=` + pageSize,
    type: 'GET',
    dataType: 'json',

    success: function (response) {

      // 리뷰
      loadReviews(response.reviewDetails);

      // 리뷰 페이징
      loadPaging(response.pageHandler);

    },
    error: function (error) {
      console.log('Error fetching reviews:', error);
    }
  });
}


// 리뷰 세팅
function loadReviews(reviewDetails) {

  let reviewsHtml = '';

  // 리뷰 목록을 순회하며 HTML 구성
  reviewDetails.forEach(function (review) {

    let ratingHtml = ''

    for (var i = 1; i <= 5; i++) {
      if (i <= review.rating) {
        ratingHtml += '<i class="fa fa-star"></i>'; // 전체 별
      } else if (i - review.rating < 1) {
        ratingHtml += '<i class="fa fa-star-half-o"></i>'; // 반 별
      } else {
        ratingHtml += '<i class="fa fa-star-o"></i>'; // 빈 별
      }
    }

    reviewsHtml +=
        `<div class="review-container">
          <div class="review-header">
            <span class="review-rating"> ` + ratingHtml + `</span>
          </div>
          <div class="review-details">
            <span>` + review.consumerName + ` ㆍ ` + review.createdAt + `</span><br>
            <span>컬러: ` + review.optionColor + ` / 사이즈: ` + review.optionSize + `</span>
          </div>
          <div class="review-body">` + review.reviewText + `</div>
        </div>`;
  });

  $('.reviewSection').html(reviewsHtml);
}


// 리뷰 페이징 세팅
function loadPaging(pageHandler) {

  let pageHandlerHtml =
      `<!-- 처음 페이지 -->
          <li class="page-item ` + (pageHandler.page > 1 ? '' : 'disabled') + `">
            <a class="page-link" href="#" data-page="1" aria-label="First">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          
          <!-- 이전 페이지 -->
          <li class="page-item ` + (pageHandler.page > 1 ? '' : 'disabled') + `">
            <a class="page-link" href="#" data-page="`+ (pageHandler.page - 1) + `" aria-label="Previous">
              <span aria-hidden="true">&lsaquo;</span>
            </a>
          </li>`;

  for (let i = pageHandler.naviBegin; i <= pageHandler.naviEnd; i++) {
    pageHandlerHtml +=
          `<!-- 페이지 번호들 -->
          <li class="page-item ` + (i == pageHandler.page ? 'active' : '') + `">
            <a class="page-link" href="#" data-page="` + i + `">` + i + `</a>
          </li>`;
  }

  pageHandlerHtml +=
          `<!-- 다음 페이지 -->
          <li class="page-item ` + (pageHandler.page < pageHandler.totalPageSize ? '' : 'disabled') + `">
            <a class="page-link" href="#" data-page="` + (pageHandler.page + 1) + `" aria-label="Next">
              <span aria-hidden="true">&rsaquo;</span>
            </a>
          </li>
          
          <!-- 마지막 페이지 -->
          <li class="page-item ` + (pageHandler.page< pageHandler.totalPageSize ? '' : 'disabled') + `">
            <a class="page-link" href="#" data-page="`+ pageHandler.totalPageSize + `" aria-label="Last">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>`;

  $('#reviewPagination').html(pageHandlerHtml);

  // 페이지 링크 클릭 이벤트를 추가합니다.
  $('.pagination .page-link').on('click', function (e) {
    e.preventDefault();
    var selectedPage = $(this).data('page');
    findReviews(productId, selectedPage, 5);
  });
}
