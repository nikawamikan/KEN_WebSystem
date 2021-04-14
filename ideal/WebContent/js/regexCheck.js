export function passwordRegexCheck(pass) {
	const regex = new RegExp('^[a-zA-Z0-9]+$');
	return regex.test(pass);
};

export function numberRegexCheck(num) {
	const regex = new RegExp('^[0-9]+$');
	return regex.test(num);
};

export function mailRegexCheck(mail) {
	const regex = new RegExp('^[\\w]+((\\.[\\w-_])*[\\w-_]*)*@[\\w]+((\\.[\\w-_])*[\\w-_]*)*[\\w]+$');
	return regex.test(mail);
};

export function zipCodeRegexCheck(zipCode) {
	const regex = new RegExp('^[0-9]{3}-?[0-9]{4}$');
	return regex.test(zipCode);
};
