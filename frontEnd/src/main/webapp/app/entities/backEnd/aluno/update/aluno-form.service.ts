import { Injectable } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { IAluno, NewAluno } from '../aluno.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IAluno for edit and NewAlunoFormGroupInput for create.
 */
type AlunoFormGroupInput = IAluno | PartialWithRequiredKeyOf<NewAluno>;

type AlunoFormDefaults = Pick<NewAluno, 'id'>;

type AlunoFormGroupContent = {
  id: FormControl<IAluno['id'] | NewAluno['id']>;
  nome: FormControl<IAluno['nome']>;
  email: FormControl<IAluno['email']>;
  dtNascimento: FormControl<IAluno['dtNascimento']>;
  cpf: FormControl<IAluno['cpf']>;
};

export type AlunoFormGroup = FormGroup<AlunoFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class AlunoFormService {
  createAlunoFormGroup(aluno: AlunoFormGroupInput = { id: null }): AlunoFormGroup {
    const alunoRawValue = {
      ...this.getFormDefaults(),
      ...aluno,
    };
    return new FormGroup<AlunoFormGroupContent>({
      id: new FormControl(
        { value: alunoRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      nome: new FormControl(alunoRawValue.nome, {
        validators: [Validators.required],
      }),
      email: new FormControl(alunoRawValue.email, {
        validators: [Validators.required, Validators.pattern('(^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$)')],
      }),
      dtNascimento: new FormControl(alunoRawValue.dtNascimento, {
        validators: [Validators.required],
      }),
      cpf: new FormControl(alunoRawValue.cpf, {
        validators: [Validators.required, Validators.pattern('([0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?([0-9]){2})')],
      }),
    });
  }

  getAluno(form: AlunoFormGroup): IAluno | NewAluno {
    return form.getRawValue() as IAluno | NewAluno;
  }

  resetForm(form: AlunoFormGroup, aluno: AlunoFormGroupInput): void {
    const alunoRawValue = { ...this.getFormDefaults(), ...aluno };
    form.reset(
      {
        ...alunoRawValue,
        id: { value: alunoRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): AlunoFormDefaults {
    return {
      id: null,
    };
  }
}
