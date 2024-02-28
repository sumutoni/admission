const form = document.getElementById('form');
const fname = document.getElementById('firstname');
const lname = document.getElementById('lastname');
const phone = document.getElementById('phone');
const email = document.getElementById('email');
const add = document.getElementById('address');
const ftname = document.getElementById('fathname');
const mtname = document.getElementById('mothname');
const bctry = document.getElementById('country');
const bcty = document.getElementById('city');
const rctry = document.getElementById('residence');
const rcty = document.getElementById('resicity');
const dept = document.getElementById('department');

form.addEventListener('submit', e =>{
    e.preventDefault();

    validateInput();
    //form.classList.add('was-validated');
    

});
const validateInput = () =>{
    const fnamevalue = fname.value.trim();
    const lnamevalue = lname.value.trim();
    const phonevalue = phone.value.trim();
    const emailvalue = email.value.trim();
    const ftnamevalue = ftname.value.trim();
    const mtnamevalue = mtname.value.tim();
    const bctryvalue = bctry.value.trim();
    const bcityvalue = bcty.value.trim();
    const rctryvalue = rctry.value.trim();
    const rctyvalue = rcty.value.trim();
    const deptvalue = dept.value.trim();
    const addvalue = add.value.trim();
    const emailpattern = /[A-Za-z0-9\.\_\-]+@[A-Za-z]{2,}\.[A-Za-z\.]{2,}/;
    const phonepattern = /(07)(8|9|3)[0-9]{7}/;
    const addpattern = /(KK|Kk|kk|KG|Kg|kg|KN|Kn|kn)\ [0-9]{2,3}\ (ST|st|St|sT|ave|Ave|AVE)/;
    
    if (fnamevalue === ''){
        const parent = fname.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide your first name!';
        fname.classList.add('is-invalid');
    }
    else{
        fname.classList.remove('is-invalid');
        fname.classList.add('is-valid');
        const parent = fname.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = '';
    }
    if (lnamevalue === ''){
        const parent = lname.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide your last name!';
        lname.classList.add('is-invalid');
    }
    else{
        lname.classList.remove('is-invalid');
        lname.classList.add('is-valid');
        const parent = lname.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = '';
    }

    if (emailvalue === ''){
        const parent = email.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide your email!';
        email.classList.add('is-invalid');
    }
    else if (!emailpattern.test(emailvalue)){
        const parent = email.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'your email is incorrect!';
        email.classList.add('is-invalid');
    }
    else{
        email.classList.remove('is-invalid');
        email.classList.add('is-valid');
        const parent = email.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = '';
    }

    if (addvalue === ''){
        const parent = add.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide your street address!';
        add.classList.add('is-invalid');
    }
    else if (!addpattern.test(addvalue)){
        const parent = add.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'your address is incorrect!';
        add.classList.add('is-invalid');
    }
    else{
        add.classList.remove('is-invalid');
        add.classList.add('is-valid');
        const parent = add.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = '';
    }

    if (phonevalue === ''){
        const parent = phone.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide your phone number!';
        phone.classList.add('is-invalid');
    }
    else if (phonevalue.length < 10){
        const parent = phone.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'phone number must be 10 digits long!';
        phone.classList.add('is-invalid');
    }
    else if (!phonepattern.test(phonevalue)){
        const parent = phone.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Incorrect format! Use 07... format';
        phone.classList.add('is-invalid');

    }
    else{
        phone.classList.remove('is-invalid');
        phone.classList.add('is-valid');
        const parent = phone.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = '';
    }

    if (ftnamevalue == '' || mtnamevalue == ''){
        const parent = ftname.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide parent\'s name!';
        ftname.classList.add('is-invalid');
    }
    if (mtnamevalue == ''){
        const parent = mtname.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide parent\'s name!';
        mtname.classList.add('is-invalid');
    }

    if (bcityvalue == '' || bctryvalue == ''){
        const parent = bcty.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide place of birth!';
        bcty.classList.add('is-invalid');
    }
    if (bctryvalue == ''){
        const parent = bctry.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide place of birth!';
        bctry.classList.add('is-invalid');
    }

    if (rctyvalue == '' || rctryvalue == ''){
        const parent = rcty.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide place of residence!';
        rcty.classList.add('is-invalid');
    }
    if (rctryvalue == ''){
        const parent = rctry.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please provide place of residence!';
        rctry.classList.add('is-invalid');
    }
    if (deptvalue == ''){
        const parent = dept.parentElement;
        const error = parent.querySelector('.error');
        error.textContent = 'Please select a department!';
        dept.classList.add('is-invalid');
    }
};

