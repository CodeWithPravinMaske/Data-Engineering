# CLAUDE.md

Personal **public** learning repo for data engineering (GitHub: `CodeWithPravinMaske/Data-Engineering`). It holds notes, PDFs, curated links, and small code samples. There's no build and no tests.

## Layout

- Numbered top-level sections (`01-Fundamentals` … `13-Software-Engineering`), with `12-Notes` and `resources/` alongside. Topic subfolders sit inside each section.
- **Every folder has a `README.md`** with a one-line summary, then *What to Learn*, *Official Links*, *Sections* (subfolder table), and *Files* (links to the folder's files). Follow that shape for any new folder, and add the new folder to its parent's *Sections* table and, if it's a new section, to the root `README.md`.
- File-name links in READMEs are URL-encoded (spaces → `%20`). After editing, check that every relative link resolves.
- `resources/Open-Source-Tools.md` is the tools catalog; `resources/YouTube.md` holds video links grouped by creator.
- Material placement: interview Q&A goes to `11-Interview-Preparation/<topic>/`, concept notes go to the matching topic folder (e.g. `01-Fundamentals/SQL/`), and non-data-engineering material goes to `13-Software-Engineering/`.

## Content rules (important)

- **This repo is public. Never add paid course material.** Specifically, nothing from the local folder `~/Desktop/personal/PDF or books learning /Summit Mittal -  26th July 2025` (a paid course). When copying from that parent folder, exclude it, and afterwards check by hash that nothing from it slipped in.
- Paid notes go to the separate **private** repo `CodeWithPravinMaske/Private-Data-Engineering` (local: `~/Desktop/personal/Private-Data-Engineering`), never here.
- Don't scrape or download from Instagram or other creators' accounts. Link to their work, and credit the author in the README when adding a file they share themselves.
- Prefer links to free official resources over copying PDFs.
- Before adding a YouTube video, verify its uploader (`https://www.youtube.com/oembed?url=<video-url>&format=json` → `author_name`). Search results mix in other channels.
- Don't commit build output or IDE files (`target/`, `.idea/workspace.xml`, `.DS_Store`). GitHub rejects files over 100 MB.

## Git

- Commit as the personal account, which is set in this repo's local git config: `Pravin Jaywantrao Maske <50141601+CodeWithPravinMaske@users.noreply.github.com>`, **not** the work email. `gh` has two accounts logged in; `CodeWithPravinMaske` must be the active one (`gh auth switch --user CodeWithPravinMaske`).
- The machine often runs a work VPN (`utun`, `10.8.0.x`). Large HTTPS pushes hang after `Total N …` while it's on. Push in small batches, use `git config http.version HTTP/1.1`, or turn the VPN off.
- The default SSH key authenticates as the **work** account (`pravinm-spry`), so use HTTPS for this repo.
