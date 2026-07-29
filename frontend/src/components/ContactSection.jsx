function ContactSection() {
  return (
    <section id="contacto" className="section contact-section">
      <div className="section-inner contact-grid">
        <div>
          <p className="eyebrow">Contacto</p>
          <h2>Hablemos de tu estancia</h2>
          <p>
            Dejanos tus datos y el equipo de la residencia te respondera para resolver dudas sobre habitaciones, disponibilidad y servicios.
          </p>
          <address className="contact-details">
            <a href="mailto:info@domusuniversia.com">info@domusuniversia.com</a>
            <a href="tel:+34900111222">+34 900 111 222</a>
          </address>
        </div>
        <form className="contact-form">
          <label>
            Nombre
            <input type="text" name="name" autoComplete="name" />
          </label>
          <label>
            Email
            <input type="email" name="email" autoComplete="email" />
          </label>
          <label>
            Mensaje
            <textarea name="message" rows="5" />
          </label>
          <button type="submit">Enviar solicitud</button>
        </form>
      </div>
    </section>
  )
}

export default ContactSection
