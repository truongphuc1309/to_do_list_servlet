const $ = document.querySelector.bind(document);

const newInput = $('input.new');
const submitBtn = $('.submit')
const form = $('.form')
const updateBtn = $('.update')

submitBtn.onclick = () => {
	if (newInput.value.length > 0)
		form.submit();
}
