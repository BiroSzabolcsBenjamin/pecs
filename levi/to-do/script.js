document.addEventListener('DOMContentLoaded', () => {
    load();

    async function load() {
        const res = await fetch('index.php');
        const tasks = await res.json();
        const list = document.getElementById('list');
        list.innerHTML = '';
        tasks.forEach(t => {
            const div = document.createElement('div');
            div.className = 'task' + (t.done ? ' done' : '');
            div.innerHTML = `<b>${t.title}</b> – ${t.description} (határidő: ${t.deadline})`;
            if (!t.done) {
                const btn = document.createElement('button');
                btn.textContent = 'Kész';
                btn.onclick = () => markDone(t.id, div, btn);
                div.appendChild(btn);
            }
            list.appendChild(div);
        });
    }

    async function markDone(id, div, btn) {
        await fetch('index.php', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ id })
        });
        div.classList.add('done');
        btn.remove();
    }
});