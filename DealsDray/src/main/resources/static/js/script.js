document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('dealsForm');
    form.addEventListener('submit', async function (event) {
        event.preventDefault();

        const formData = {
            email: form.email.value,
            password: form.password.value,
            phone: form.phone.value,
            referralcode: form.referralcode.value
        };

        try {
            const response = await fetch('/DealsDray', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });

            if (response.ok) {
                alert('Data submitted successfully!');
            } else {
                alert('Error submitting data');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('Error submitting data');
        }
    });
});
